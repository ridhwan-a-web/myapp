package com.example.myapp.data

import android.content.Context
import android.widget.Toast
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import com.example.myapp.models.Client
import com.example.myapp.navigation.ROUTE_VIEW_CLIENT
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener


class ClientViewModel(): ViewModel() {
    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean> get() =_isLoading

    private val _errorMessage = MutableLiveData<String>()
    val errorMessage: LiveData<String> get() = _errorMessage

    private val _successMessage = MutableLiveData<String>()
    val successMessage: LiveData<String> get() = _successMessage

    fun saveClient(firstname:String, lastname:String,
                   gender:String, age:String, navController: NavController, context:Context){
        val id = System.currentTimeMillis().toString()
        val dbRef = FirebaseDatabase.getInstance().getReference("Client/$id")

        val clientData = Client("", firstname, lastname, gender, age, id)
        dbRef.setValue(clientData).addOnCompleteListener{ task ->
            if (task.isSuccessful){
                showToast("Client added successfully", context)
                navController.navigate(ROUTE_VIEW_CLIENT)
            }else{
                showToast("Client not added successfully", context)
            }
        }
    }
    public fun showToast(message:String,context: Context){
        Toast.makeText(context,message,Toast.LENGTH_LONG).show()
    }

    fun viewClients(client: MutableState<Client>,
                   clients: SnapshotStateList<Client>,
                   context: Context): SnapshotStateList<Client>{
        val ref = FirebaseDatabase.getInstance().getReference().child("Client")
        ref.addValueEventListener(object : ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                clients.clear()
                for (snap in snapshot.children){
                   val value = snap.getValue(Client::class.java)
                   client.value = value!!
                   clients.add(value)
                }
            }

            override fun onCancelled(error: DatabaseError) {
                showToast("Failed to fetch clients", context)
            }
        })
        return clients
    }

    fun updateClient(
        context: Context, navController: NavController,
        firstname: String, lastname: String, gender: String, age: String, id: String
    ){
        val databaseReference = FirebaseDatabase.getInstance().getReference("Client/$id")
        val updatedClient = Client("", firstname, lastname, gender, age, id)

        databaseReference.setValue(updatedClient).addOnCompleteListener{task ->
            if (task.isSuccessful){
                showToast("Client updated successfully", context)
                navController.navigate(ROUTE_VIEW_CLIENT)
            }else{
                showToast("Record update failed", context)
            }
        }
    }

}