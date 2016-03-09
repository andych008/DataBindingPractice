package com.dwgg.databindingpractice.ui;

import android.app.Fragment;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.dwgg.databindingpractice.R;
import com.dwgg.databindingpractice.databinding.FragmentNoteBinding;
import com.dwgg.databindingpractice.model.NoteModel;
import com.dwgg.databindingpractice.vmdata.NoteVMData;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link NoteFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class NoteFragment extends Fragment {

    private FragmentNoteBinding binding;

    private NoteModel model;

    private NoteVMData vmData;

    public NoteFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment NoteFragment.
     */
    public static NoteFragment newInstance() {
        NoteFragment fragment = new NoteFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        model = new NoteModel();
        vmData = new NoteVMData();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_note, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding.setData(vmData);
        binding.setListener(this);
    }

    public void onClickPrint(View view){
        String text = binding.etInput.getText().toString();
        vmData.setContent(model.print(text));
    }
}
