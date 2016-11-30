package pickeat.com.pickeat.model.realm;

import io.realm.Realm;
import io.realm.RealmList;
import io.realm.RealmObject;
import pickeat.com.pickeat.model.firebase.Question;

/**
 * Created by Refael Ozeri on 10/09/2016.
 */
public class RealmQuestion extends RealmObject {

  private String key;
  private String question;
  private String image;
  private RealmAnswer answer1;
  private RealmAnswer answer2;
  private RealmAnswer answer3;
  private RealmAnswer answer4;

  public RealmQuestion() {
  }

  public String getKey() {
    return key;
  }

  public void setKey(String key) {
    this.key = key;
  }

  public String getQuestion() {
    return question;
  }

  public void setQuestion(String question) {
    this.question = question;
  }

  public String getImage() {
    return image;
  }

  public void setImage(String image) {
    this.image = image;
  }

  public RealmAnswer getAnswer1() {
    return answer1;
  }

  public void setAnswer1(RealmAnswer answer1) {
    this.answer1 = answer1;
  }

  public RealmAnswer getAnswer2() {
    return answer2;
  }

  public void setAnswer2(RealmAnswer answer2) {
    this.answer2 = answer2;
  }

  public RealmAnswer getAnswer3() {
    return answer3;
  }

  public void setAnswer3(RealmAnswer answer3) {
    this.answer3 = answer3;
  }

  public RealmAnswer getAnswer4() {
    return answer4;
  }

  public void setAnswer4(RealmAnswer answer4) {
    this.answer4 = answer4;
  }

  public static RealmQuestion writeNewQuestion(final Realm realm, Question question) {

    RealmAnswer answer1 = RealmAnswer.writeNewAnswer(realm, question.getAnswer1());
    RealmAnswer answer2 = RealmAnswer.writeNewAnswer(realm, question.getAnswer2());
    RealmAnswer answer3 = RealmAnswer.writeNewAnswer(realm, question.getAnswer3());
    RealmAnswer answer4 = RealmAnswer.writeNewAnswer(realm, question.getAnswer4());

    realm.beginTransaction();
    RealmQuestion realmQuestion = realm.createObject(RealmQuestion.class);
    realmQuestion.setKey(question.getKey());
    realmQuestion.setQuestion(question.getQuestion());
    realmQuestion.setImage(question.getImage());
    realmQuestion.setAnswer1(answer1);
    realmQuestion.setAnswer2(answer2);
    realmQuestion.setAnswer3(answer3);
    realmQuestion.setAnswer4(answer4);
    realm.commitTransaction();

    return realmQuestion;
  }

  public static String getLeadToQuestionString(RealmQuestion question, int answerNum) {
    switch (answerNum) {
      case 1:
        return question.getAnswer1().getLeadTo();
      case 2:
        return question.getAnswer2().getLeadTo();
      case 3:
        return question.getAnswer3().getLeadTo();
      case 4:
        return question.getAnswer4().getLeadTo();
      default:
        return question.getAnswer1().getLeadTo();
    }
  }
}
