package pickeat.com.pickeat.ui.fragments;

/**
 * Created by Refael Ozeri on 10/09/2016.
 */
public interface questionsFragmentInteractionListener {
  void startQuestions();
  void onQuestionAnswered(int answer);
  void onIngredientAdded();
}
