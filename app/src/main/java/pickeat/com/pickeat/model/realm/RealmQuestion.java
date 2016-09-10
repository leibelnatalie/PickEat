package pickeat.com.pickeat.model.realm;

import io.realm.RealmObject;
import pickeat.com.pickeat.model.firebase.Question;

/**
 * Created by Refael Ozeri on 10/09/2016.
 */
public class RealmQuestion extends RealmObject {

  private String question;
  private String image;
  private RealmAnswer answer1;
  private RealmAnswer answer2;
  private RealmAnswer answer3;
  private RealmAnswer answer4;

  public RealmQuestion() {
  }

  public RealmQuestion(Question question) {
    this.question = question.getQuestion();
    this.image = question.getImage();
    this.answer1 = new RealmAnswer(question.getAnswer1());
    this.answer2 = new RealmAnswer(question.getAnswer2());
    this.answer3 = new RealmAnswer(question.getAnswer3());
    this.answer4 = new RealmAnswer(question.getAnswer4());
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
}
