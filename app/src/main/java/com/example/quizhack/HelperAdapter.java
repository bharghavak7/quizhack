package com.example.quizhack;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class HelperAdapter extends RecyclerView.Adapter {
    List<Fetch_Questions> fetchdatalist;

    public HelperAdapter(List<Fetch_Questions> fetchdatalist) {
        this.fetchdatalist = fetchdatalist;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view   = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout,parent,false);
        ViewHolderClass viewHolderClass=new ViewHolderClass(view);
        return viewHolderClass;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ViewHolderClass viewHolderClass=(ViewHolderClass)holder;
        Fetch_Questions fetchQuestions=fetchdatalist.get(position);
        viewHolderClass.question.setText(fetchQuestions.getQuestions());
        viewHolderClass.option1.setText(fetchQuestions.getOptions1());
        viewHolderClass.option2.setText(fetchQuestions.getOptions2());
        viewHolderClass.option3.setText(fetchQuestions.getOptions3());
        viewHolderClass.option4.setText(fetchQuestions.getOptions4());
        viewHolderClass.ans.setText(fetchQuestions.getAns());

    }

    @Override
    public int getItemCount() {
        return fetchdatalist.size();
    }
    public class ViewHolderClass extends RecyclerView.ViewHolder{
            TextView question,option1,option2,option3,option4,ans;
        public ViewHolderClass(@NonNull View itemView) {
            super(itemView);
            question=itemView.findViewById(R.id.questions);
            option1=itemView.findViewById(R.id.options1);
            option2=itemView.findViewById(R.id.options2);;
            option3=itemView.findViewById(R.id.options3);;
            option4=itemView.findViewById(R.id.options4);
            ans=itemView.findViewById(R.id.answers);
        }
    }
}
