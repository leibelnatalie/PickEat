package pickeat.com.pickeat.ui.fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import pickeat.com.pickeat.R;

public class QuestionOptional extends Fragment implements View.OnClickListener {

  private View mBackBtn, mSkipOrNext;

  private questionsFragmentInteractionListener mListener;

  public QuestionOptional() {
    // Required empty public constructor
  }

  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container,
                           Bundle savedInstanceState) {
    // Inflate the layout for this fragment
    View view = inflater.inflate(R.layout.fragment_question_optional, container, false);

    mBackBtn = view.findViewById(R.id.optional_back);
    mSkipOrNext = view.findViewById(R.id.optional_skip);

    mBackBtn.setOnClickListener(this);
    mSkipOrNext.setOnClickListener(this);

    return view;
  }

  public void startQuestions() {
    if (mListener != null) {
      mListener.startQuestions();
    }
  }

  //todo - handle this
  public void onIngredientAdded() {
    if (mListener != null) {
      mListener.onIngredientAdded();
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
    switch (v.getId()) {
      case R.id.optional_back:
        getActivity().onBackPressed();
        break;
      case R.id.optional_skip:
        startQuestions();
        break;
    }
  }
}
