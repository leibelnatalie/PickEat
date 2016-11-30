package pickeat.com.pickeat.model.realm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import io.realm.Realm;
import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.RealmResults;
import pickeat.com.pickeat.model.firebase.Question;

/**
 * Created by Refael Ozeri on 10/09/2016.
 */
public class RealmCategory extends RealmObject {

  private String mCategoryName;
  private RealmList<RealmQuestion> mQuestions;

  public String getCategoryName() {
    return mCategoryName;
  }

  public void setCategoryName(String categoryName) {
    mCategoryName = categoryName;
  }

  public RealmList<RealmQuestion> getQuestions() {
    return mQuestions;
  }

  public void setQuestions(RealmList<RealmQuestion> questions) {
    mQuestions = questions;
  }

  private static void writeNewCategory(final Realm realm, final String categoryName, final RealmList<RealmQuestion> questions) {
    realm.beginTransaction();
    RealmCategory category = realm.createObject(RealmCategory.class);
    category.setCategoryName(categoryName);
    category.setQuestions(questions);
    realm.commitTransaction();
  }

  public static void deleteAllCategories(Realm realm) {
    final RealmResults<RealmCategory> results = realm.where(RealmCategory.class).findAll();
    realm.beginTransaction();
    results.deleteAllFromRealm();
    realm.commitTransaction();

    final RealmResults<RealmQuestion> results1 = realm.where(RealmQuestion.class).findAll();
    realm.beginTransaction();
    results1.deleteAllFromRealm();
    realm.commitTransaction();

    final RealmResults<RealmAnswer> results2 = realm.where(RealmAnswer.class).findAll();
    realm.beginTransaction();
    results2.deleteAllFromRealm();
    realm.commitTransaction();
  }

  public static void saveCategory(Realm realm, String categoryName, ArrayList<Question> questionsMap) {

    RealmList<RealmQuestion> realmQuestions = new RealmList<>();

    for (Question question : questionsMap) {
      RealmQuestion realmQuestion = RealmQuestion.writeNewQuestion(realm, question);
      realmQuestions.add(realmQuestion);
    }

    writeNewCategory(realm, categoryName, realmQuestions);
  }
}
