package com.salugan.cobakeluar.core.data.firebase

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.liveData
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.salugan.cobakeluar.core.data.firebase.entities.HasilEntity
import com.salugan.cobakeluar.core.data.firebase.entities.UserEntity
import com.salugan.cobakeluar.core.utils.Result
import com.salugan.cobakeluar.utils.DeviceConnection
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class FirebaseDataSource @Inject constructor(
    private val db: FirebaseDatabase,
    private val context: Context
) {
    fun insertUser(addData: UserEntity): LiveData<Result<String>> {
        val resultAddData = MutableLiveData<Result<String>>()
        val database = db.getReference("users")
        val spesificDatabase = database.child(addData.userId!!)

        spesificDatabase.setValue(addData)
            .addOnSuccessListener {
                resultAddData.value = Result.Success("Data berhasil disimpan")
            }
            .addOnFailureListener { error ->
                resultAddData.value = Result.Error(error.message ?: "Terjadi kesalahan")
            }
        return resultAddData
    }

    fun getUser(userId: String): LiveData<Result<UserEntity>> {
        val resultDataProfile = MutableLiveData<Result<UserEntity>>()
        resultDataProfile.value = Result.Loading
        val database = db.getReference("users")
        val query = database.orderByChild("userId").equalTo(userId)
        query.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                val foundUser = mutableListOf<UserEntity>()
                for (dataSnapshot in snapshot.children) {
                    val user = dataSnapshot.getValue(UserEntity::class.java)
                    user?.let { foundUser.add(it) }
                }
                if (foundUser.isNotEmpty()) {
                    resultDataProfile.value = Result.Success(foundUser[0])
                } else {
                    resultDataProfile.value = Result.Error("User tidak ditemukan")
                }
            }

            override fun onCancelled(error: DatabaseError) {
                resultDataProfile.value = Result.Error(error.message)
            }
        })
        return resultDataProfile
    }


    //Hasill try out
    fun hasilTryOut(addData: HasilEntity): LiveData<Result<String>> {
        val resulHasilTO = MutableLiveData<Result<String>>()
        val userRef = db.getReference("users")
        val userSpecificRef = userRef.child(addData.userId!!).child("tryout")
        val newUserRef = userSpecificRef.push()

        newUserRef.setValue(addData)
            .addOnSuccessListener {
                resulHasilTO.value = Result.Success("Data berhasil disimpan")
            }
            .addOnFailureListener { error ->
                resulHasilTO.value = Result.Error(error.message ?: "Terjadi kesalahan")
            }

        return resulHasilTO
    }

    fun getHasilTryout(userId: String): LiveData<Result<List<HasilEntity>>> = liveData {
        val userRef = db.getReference("users")


        val liveData = MutableLiveData<Result<List<HasilEntity>>>()
        liveData.value = Result.Loading

        if (!DeviceConnection.isNetworkConnected(context)) {
            liveData.value = Result.Error("Check your internet connection")
        }

        val tryoutsRef = userRef.child(userId).child("tryout")

        val tryoutsListener = object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                val tryoutsList = mutableListOf<HasilEntity>()

                dataSnapshot.children.forEach { tryoutSnapshot ->
                    val tryout = tryoutSnapshot.getValue(HasilEntity::class.java)
                    if (tryout != null) {
                        tryoutsList.add(tryout)
                    }
                }

                liveData.value = Result.Success(tryoutsList)
            }

            override fun onCancelled(error: DatabaseError) {
                liveData.value = Result.Error(error.message)
            }
        }

        tryoutsRef.addValueEventListener(tryoutsListener)

        emitSource(liveData)
    }
}