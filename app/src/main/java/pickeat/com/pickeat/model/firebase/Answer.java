package pickeat.com.pickeat.model.firebase;

import com.google.firebase.database.IgnoreExtraProperties;

/**
 * Created by Refael Ozeri on 10/09/2016.
 */
@IgnoreExtraProperties
public class Answer {

  private String answer;
  private String type;

  public Answer() {
    // Default constructor required for calls to DataSnapshot.getValue(User.class)
  }

  public Answer(String answer, String type) {
    this.answer = answer;
    this.type = type;
  }

  public String getAnswer() {
    return answer;
  }

  public void setAnswer(String answer) {
    this.answer = answer;
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }
}
