package com.example.test2.a;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.test1.R;

import org.w3c.dom.Text;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link A_Fragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class A_Fragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public A_Fragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment A_Fragment.
     */
    // TODO: Rename and change types and number of parameters
    public static A_Fragment newInstance(String param1, String param2) {
        A_Fragment fragment = new A_Fragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_a_, container, false);
    }

    private ImageView imageView;
    private TextView textView;
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        imageView=view.findViewById(R.id.imageView_fargemnt);
        textView=view.findViewById(R.id.textView_fragment);
        super.onViewCreated(view, savedInstanceState);
        switch (mParam1){
            case "1":
                imageView.setImageResource(R.drawable.img_2);
                textView.setText("计算机学院成立至今，已经发展成为集本科、硕士、博士教育、科学研究、人才培养和社会服务为一体的综合性学院。学院秉承“严谨、创新、服务” 的办学理念，致力于为社会培养高素质、具有国际视野和创新精神的计算机科学与技术专业人才。");
                break;
            case "2":
                imageView.setImageResource(R.drawable.img_3);
                textView.setText("计算机学院拥有一支高水平、高质量的教师队伍，其中教授、副教授和博士生导师占比达到80%以上。学院拥有多位国家级和省级优秀教师，其中包括国家级教学名师、国家级优秀教师、广东省高校“千百十工程”人才、广东省领军人才等。");
                break;
            case "3":
                imageView.setImageResource(R.drawable.img_2);
                textView.setText("学院现有本科生1500余人，硕士研究生300余人，博士研究生70余人。学院本科生毕业生就业率连续多年位居广东省计算机专业前列，被广大用人单位广泛认可。");
                break;
            case "4":
                imageView.setImageResource(R.drawable.img_4);
                textView.setText("学院注重学生综合素质的培养，开展了丰富多彩的学生活动，包括学术讲座、科技创新、社会实践、文体活动等。学院积极组织参加国内外各种学术竞赛和技能竞赛，如“蓝桥杯”、“ACM程序设计大赛”、“全国大学生数学建模竞赛”等，学生在各类竞赛中多次获得国家级、省级和校级奖项。同时，学院还为学生提供了多种实践机会，如暑期实习、企业实训、创新创业等，帮助学生提升实践能力和就业竞争力。");
                break;

        }

    }
}