package pickeat.com.pickeat.model.realm;

import io.realm.RealmObject;
import pickeat.com.pickeat.model.firebase.Answer;

/**
 * Created by Refael Ozeri on 10/09/2016.
 */
public class RealmAnswer extends RealmObject {

  private String answer;
  private String type;

  public RealmAnswer() {
  }

  public RealmAnswer(Answer answer) {
    this.answer = answer.getAnswer();
    this.type = answer.getType();
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
