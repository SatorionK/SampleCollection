package com.mtechviral.musicplayer;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;


//リサイクラービューのアダプタークラス
//継承はRecyclerView.Adapter< >
//引数はジェネリクスなのでクラス（今回のサブクラスのHolderはインナークラス）

public class SongAdapter extends RecyclerView.Adapter<SongAdapter.SongHolder> {

    private ArrayList<SongInfo> _songs = new ArrayList<SongInfo>();
    private Context context;
    private OnItemClickListener mOnItemClickListener;

//--------------------------------------------------------------------------------------------------
    //コンストラクタ
    //大抵ここで、リストデータを入れる
    public SongAdapter(Context context, ArrayList<SongInfo> songs) {
        this.context = context;
        this._songs = songs;
    }

//--------------------------------------------------------------------------------------------------
    //OnItemClickListenerとsetOnItemClickListenerはセット（通常のボタンと一緒。ただ分裂したのみ）

    public void setOnItemClickListener(final OnItemClickListener mItemClickListener) {
        this.mOnItemClickListener = mItemClickListener;
    }
    //オーヴァーライドしていない。自由に引数を決めてOK
    public interface OnItemClickListener {
        void onItemClick(Button b ,View view, SongInfo obj, int position);
    }

//--------------------------------------------------------------------------------------------------
    //ビューホルダーのオブジェクト生成メソッド（恐らくnewしてインスタンスは作れるが、引数を
    // 用意しなくてはならないためこのような処置をとる）
    @Override
    public SongHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        //LayoutInflaterクラスのfromメソッドとinflateメソッドの直列
        View myView = LayoutInflater.from(context).inflate(R.layout.row_songs,viewGroup,false);
        return new SongHolder(myView);
    }

//--------------------------------------------------------------------------------------------------
    //表示データの割り当てメソッド
    @Override
    public void onBindViewHolder(final SongHolder songHolder, final int i) {
            //要素の取り出し
            //ArrayListクラスのgetメソッドでタップした要素を取得
            //holderのフィールドに値を入れる
            final SongInfo s = _songs.get(i);
            //曲名
            songHolder.tvSongName.setText(_songs.get(i).getSongname());
            //アーティスト名
            songHolder.tvSongArtist.setText(_songs.get(i).getArtistname());
            //ボタンのアクション
            songHolder.btnAction.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (mOnItemClickListener != null) {
                        mOnItemClickListener.onItemClick(songHolder.btnAction,v, s, i);
                    }
                }
            });
    }
//--------------------------------------------------------------------------------------------------
    //リストの行数（必須）
    @Override
    public int getItemCount() {
        return _songs.size();
    }

//--------------------------------------------------------------------------------------------------
//--------------------------------------------------------------------------------------------------
    //リサイクラービュホルダークラス（インナークラス）Viewのインスタンス化が目的
    //1行内のレイアウトが目的
    public class SongHolder extends RecyclerView.ViewHolder {

        TextView tvSongName,tvSongArtist;
        Button btnAction;

//--------------------------------------------------------------------------------------------------
        //コンストラクタ：お作法で引数は「View itemView」で固定
        //1行内表示する文字や画像、ボタンなどのウィジェットをインスタンス化
        //row.xmlのウィジェットをインスタンス化
        public SongHolder(View itemView) {
            //superもお作法
            super(itemView);
            tvSongName = (TextView) itemView.findViewById(R.id.tvSongName);
            tvSongArtist = (TextView) itemView.findViewById(R.id.tvArtistName);
            btnAction = (Button) itemView.findViewById(R.id.btnPlay);
        }
    }
//--------------------------------------------------------------------------------------------------
}
