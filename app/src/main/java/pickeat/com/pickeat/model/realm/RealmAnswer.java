package pickeat.com.pickeat.model.realm;

import io.realm.Realm;
import io.realm.RealmObject;
import pickeat.com.pickeat.model.firebase.Answer;

/**
 * Created by Refael Ozeri on 10/09/2016.
 */
public class RealmAnswer extends RealmObject {

  private String answer;
  private String leadTo;
  private String tags;

  public RealmAnswer() {
  }

  public String getAnswer() {
    return answer;
  }

  public void setAnswer(String answer) {
    this.answer = answer;
  }

  public String getLeadTo() {
    return leadTo;
  }

  public void setLeadTo(String leadTo) {
    this.leadTo = leadTo;
  }

  public String getTags() {
    return tags;
  }

  public void setTags(String tags) {
    this.tags = tags;
  }

  public static RealmAnswer writeNewAnswer(Realm realm, Answer answer) {

//    RealmList<RealmTag> realmTags = new RealmList<>();
//    if (answer.getTags() != null && !answer.getTags().isEmpty()) {
//      Iterator<Map.Entry<String, String>> iterator = answer.getTags().entrySet().iterator();
//      while (iterator.hasNext()) {
//        String tag = iterator.next().getValue();
//        realmTags.add(RealmTag.writeNewTag(realm, tag));
//        iterator.remove();
//      }
//      for (Tag tag : answer.getTags()) {
//        realmTags.add(RealmTag.writeNewTag(realm, tag.getTag()));
//      }
//    }

    realm.beginTransaction();
    RealmAnswer realmAnswer = realm.createObject(RealmAnswer.class);
    realmAnswer.setAnswer(answer.getAnswer());
    if (answer.getLeadTo() != null) {
      realmAnswer.setLeadTo(answer.getLeadTo());
    }
    if (answer.getTags() != null) {
      realmAnswer.setTags(answer.getTags());
    }
    realm.commitTransaction();

    return realmAnswer;
  }
}
