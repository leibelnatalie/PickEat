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
    realm.executeTransactionAsync(new Realm.Transaction() {
      @Override
      public void execute(Realm realm) {
        RealmCategory category = realm.createObject(RealmCategory.class);
        category.setCategoryName(categoryName);
        category.setQuestions(questions);
      }
    });
  }

  public static void deleteAllCategories(Realm realm) {
    final RealmResults<RealmCategory> results = realm.where(RealmCategory.class).findAll();
    realm.beginTransaction();
    results.deleteAllFromRealm();
    realm.commitTransaction();
  }

  public static void saveCategory(Realm realm, String categoryName, Map<String, Question> questionsMap) {

    //TODO - WTF IS THIS SHIT ?!
//    RealmList<RealmQuestion> realmQuestions = new RealmList<>();
//    Set<String> stringSet = questionsMap.keySet();
//    Iterator<String> iterator = stringSet.iterator();
//
//    while (iterator.hasNext()) {
//      String key = iterator.next();
//      HashMap<String, Question> question = questionsMap.get(key);
//      RealmQuestion realmQuestion = new RealmQuestion(question);
//      realmQuestions.add(realmQuestion);
//    }
//
//    writeNewCategory(realm, categoryName, realmQuestions);
  }
}
