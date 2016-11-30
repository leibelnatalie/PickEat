package pickeat.com.pickeat.model.firebase;

import com.google.firebase.database.IgnoreExtraProperties;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Refael Ozeri on 10/09/2016.
 */
@IgnoreExtraProperties
public class Answer {

  private String answer;
  private String leadTo;
  private String tags;

  public Answer() {
    // Default constructor required for calls to DataSnapshot.getValue(User.class)
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
}
