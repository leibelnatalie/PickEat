package pickeat.com.pickeat.business.firebase;

import android.util.Log;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Iterator;

import io.realm.Realm;
import pickeat.com.pickeat.business.SharedPref;
import pickeat.com.pickeat.model.Constants;
import pickeat.com.pickeat.model.firebase.Question;
import pickeat.com.pickeat.model.realm.RealmCategory;

/**
 * Created by Refael Ozeri on 17/09/2016.
 */
public class FirebaseUtil {

  public static void checkQuestionsVersion() {
    DatabaseReference mDatabase = FirebaseDatabase.getInstance().getReference().child(Constants.FIRE_QUESTIONS_VERSION);
    mDatabase.addListenerForSingleValueEvent(
        new ValueEventListener() {
          @Override
          public void onDataChange(DataSnapshot dataSnapshot) {
            int questionVersion = ((Long) dataSnapshot.getValue()).intValue();
            if (questionVersion != SharedPref.getQuestionVersion()) {
              fetchQuestions();
              SharedPref.saveQuestionVersion(questionVersion);
            }
          }

          @Override
          public void onCancelled(DatabaseError databaseError) {
            Log.w("blabla ", "getUser:onCancelled", databaseError.toException());
            // ...
          }
        });
  }

  private static void fetchQuestions() {

    RealmCategory.deleteAllCategories(Realm.getDefaultInstance());

    DatabaseReference mDatabase = FirebaseDatabase.getInstance().getReference().child(Constants.FIRE_QUESTIONS);
    mDatabase.addListenerForSingleValueEvent(
        new ValueEventListener() {
          @Override
          public void onDataChange(DataSnapshot dataSnapshot) {

            final Realm realm = Realm.getDefaultInstance();

            Iterator<DataSnapshot> snap = dataSnapshot.getChildren().iterator();
            while (snap.hasNext()) {
              DataSnapshot dataSnapshot1 = snap.next();
              String categoryName = dataSnapshot1.getKey();
              ArrayList<Question> questions = new ArrayList<Question>();
              Iterator<DataSnapshot> questionsIterator = dataSnapshot1.getChildren().iterator();
              while (questionsIterator.hasNext()) {
                DataSnapshot snapshot = questionsIterator.next();
                Question question = snapshot.getValue(Question.class);
                question.setKey(snapshot.getKey());
                questions.add(question);
              }

              RealmCategory.saveCategory(realm, categoryName, questions);
            }

          }

          @Override
          public void onCancelled(DatabaseError databaseError) {
            Log.w("blabla ", "getUser:onCancelled", databaseError.toException());
            // ...
          }
        });
  }
}
