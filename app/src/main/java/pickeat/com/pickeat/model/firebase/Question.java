package pickeat.com.pickeat.model.firebase;

import com.google.firebase.database.IgnoreExtraProperties;

import java.util.HashMap;

/**
 * Created by Refael Ozeri on 10/09/2016.
 */
@IgnoreExtraProperties
public class Question {

  private String key;
  private String question;
  private String image;
  private Answer answer1;
  private Answer answer2;
  private Answer answer3;
  private Answer answer4;

  public Question() {
    // Default constructor required for calls to DataSnapshot.getValue(User.class)
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

  public Answer getAnswer1() {
    return answer1;
  }

  public void setAnswer1(Answer answer1) {
    this.answer1 = answer1;
  }

  public Answer getAnswer2() {
    return answer2;
  }

  public void setAnswer2(Answer answer2) {
    this.answer2 = answer2;
  }

  public Answer getAnswer3() {
    return answer3;
  }

  public void setAnswer3(Answer answer3) {
    this.answer3 = answer3;
  }

  public Answer getAnswer4() {
    return answer4;
  }

  public void setAnswer4(Answer answer4) {
    this.answer4 = answer4;
  }
}
