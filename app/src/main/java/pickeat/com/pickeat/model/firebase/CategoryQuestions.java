package pickeat.com.pickeat.model.firebase;

import com.google.firebase.database.IgnoreExtraProperties;

import java.util.List;

/**
 * Created by Refael Ozeri on 10/09/2016.
 */
@IgnoreExtraProperties
public class CategoryQuestions {

  private List<Question> questions;

  public CategoryQuestions() {
  }

  public CategoryQuestions(List<Question> questions) {
    this.questions = questions;
  }

  public List<Question> getQuestions() {
    return questions;
  }

  public void setQuestions(List<Question> questions) {
    this.questions = questions;
  }
}
