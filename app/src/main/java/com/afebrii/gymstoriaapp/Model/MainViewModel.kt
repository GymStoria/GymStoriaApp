import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.*
import com.afebrii.gymstoriaapp.Screen.UserData

data class UserData(
    val username: String,
    val email: String,
    val nomor_hp: String
)

class MainViewModel : ViewModel() {
    private val firebaseAuth = FirebaseAuth.getInstance()
    private val firebaseDatabase = FirebaseDatabase.getInstance()
    val userDataRef: DatabaseReference = firebaseDatabase.reference.child("users")
    private val _userData = MutableLiveData<UserData?>()
    val userData: LiveData<UserData?> get() = _userData

    fun setUserData(userData: com.afebrii.gymstoriaapp.Screen.UserData) {
        _userData.value = userData
    }

    init {
        // Ambil user saat ini setiap kali ada perubahan pada Firebase Authentication
        firebaseAuth.addAuthStateListener { firebaseAuth ->
            val currentUser = firebaseAuth.currentUser
            if (currentUser != null) {
                // Gunakan UID pengguna saat ini untuk mengakses data pengguna di database
                userDataRef.child(currentUser.uid).addValueEventListener(object : ValueEventListener {
                    override fun onDataChange(snapshot: DataSnapshot) {
                        if (snapshot.exists()) {
                            val username = snapshot.child("username").getValue(String::class.java) ?: ""
                            val email = snapshot.child("email").getValue(String::class.java) ?: ""
                            val nomor_hp = snapshot.child("nomor_hp").getValue(String::class.java) ?: ""
                            _userData.postValue(UserData(username = username, email = email, nomor_hp = nomor_hp))
                        } else {
                            // Jika data pengguna tidak ada, atur LiveData menjadi null
                            _userData.postValue(null)
                        }
                    }

                    override fun onCancelled(error: DatabaseError) {
                    }
                })
            } else {
                // Jika pengguna tidak login, atur LiveData menjadi null
                _userData.postValue(null)
            }
        }
    }
}
