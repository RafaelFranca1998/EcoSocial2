package release.ecosocial.com.ecosocial.config;

//import com.google.firebase.database.DatabaseReference;
//import com.google.firebase.database.FirebaseDatabase;
//
//public class DAO {
//    private static DatabaseReference referenciaFirebase;
//    //private static FirebaseAuth autenticacao;
//
//    public DAO() {
//    }
//
//    public static DatabaseReference getFireBase(){
//        if (referenciaFirebase == null) {
//            referenciaFirebase = FirebaseDatabase.getInstance().getReference();
//        }
//        return referenciaFirebase;
//    }

//    public static FirebaseAuth getFirebaseAutenticacao(){
//        if (autenticacao == null){
//            autenticacao = FirebaseAuth.getInstance();
//        }
//        return autenticacao;
//    }

//    public void criaEvento(Eventos eventos){
//        referenciaFirebase.child("eventos").child(String.valueOf(Eventos.getDataCriacao())).child(String.valueOf(Eventos.getSerialNumber())).setValue(eventos);
//    }
//
//    public void selecionarEvento(String codigoEvento){
//        firebaseReferencia.child("eventos").child(codigoEvento).addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(DataSnapshot dataSnapshot) {
//                Eventos  eventos = dataSnapshot.getValue(Eventos.class);
//                Log.i("Eventos",eventos.toString());
//            }
//
//            @Override
//            public void onCancelled(DatabaseError databaseError) {
//                Log.i("Error","The read failed: " + databaseError.getCode());
//            }
//        });
//    }
//
//}
