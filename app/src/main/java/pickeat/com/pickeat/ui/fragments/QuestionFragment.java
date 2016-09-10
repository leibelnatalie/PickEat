package pickeat.com.pickeat.ui.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import pickeat.com.pickeat.R;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link questionsFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link QuestionFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class QuestionFragment extends Fragment implements View.OnClickListener {

  private static final String QUESTION_ID = "QUESTION_ID";

  private int mAnsweredOption = 0;
  private int mQuestionId = 0;

  private questionsFragmentInteractionListener mListener;

  //questions layout
  private RelativeLayout mOne, mTwo, mThree, mFour;

  public QuestionFragment() {
    // Required empty public constructor
  }

  public static QuestionFragment newInstance(int questionId) {
    QuestionFragment fragment = new QuestionFragment();
    Bundle args = new Bundle();
    args.putInt(QUESTION_ID, questionId);
    fragment.setArguments(args);
    return fragment;
  }

  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    if (getArguments() != null) {
      mQuestionId = getArguments().getInt(QUESTION_ID);
    }
  }

  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container,
                           Bundle savedInstanceState) {
    // Inflate the layout for this fragment
    View view = inflater.inflate(R.layout.fragment_question, container, false);
    initViews(view);
    return view;
  }

  private void initViews(View view) {
    ((TextView)view.findViewById(R.id.question_title)).setText("Test "+mQuestionId);

    mOne = (RelativeLayout) view.findViewById(R.id.question_layout_1);
    mTwo = (RelativeLayout) view.findViewById(R.id.question_layout_2);
    mThree = (RelativeLayout) view.findViewById(R.id.question_layout_3);
    mFour = (RelativeLayout) view.findViewById(R.id.question_layout_4);

    mOne.setOnClickListener(this);
    mTwo.setOnClickListener(this);
    mThree.setOnClickListener(this);
    mFour.setOnClickListener(this);
  }

  public void onAnswerSelected(int answer) {
    if (mListener != null) {
      mListener.onQuestionAnswered(answer);
    }
  }

  @Override
  public void onAttach(Context context) {
    super.onAttach(context);
    if (context instanceof questionsFragmentInteractionListener) {
      mListener = (questionsFragmentInteractionListener) context;
    } else {
      throw new RuntimeException(context.toString()
          + " must implement OnFragmentInteractionListener");
    }
  }

  @Override
  public void onDetach() {
    super.onDetach();
    mListener = null;
  }

  @Override
  public void onClick(View v) {
    int answer = 0;
    switch (v.getId()) {
      case R.id.question_layout_1:
        answer = 1;
        break;
      case R.id.question_layout_2:
        answer = 2;
        break;
      case R.id.question_layout_3:
        answer = 3;
        break;
      case R.id.question_layout_4:
        answer = 4;
        break;
    }
    if (answer != 0) {
      onAnswerSelected(answer);
    }
  }
}
