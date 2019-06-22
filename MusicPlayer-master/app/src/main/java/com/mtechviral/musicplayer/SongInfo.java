package com.mtechviral.musicplayer;

//曲情報クラス

public class SongInfo {
     //フィールド
    //String Songname：曲名
    //String Artistname：アーティスト名
    //String SongUrl：曲のURI

    private String Songname;
    private String Artistname;
    private String SongUrl;

    //コンストラクタ
    public SongInfo() {
    }

    public SongInfo(String songname, String artistname, String songUrl) {
        Songname = songname;
        Artistname = artistname;
        SongUrl = songUrl;
    }

    public String getSongname() {
        return Songname;
    }

    public String getArtistname() {
        return Artistname;
    }

    public String getSongUrl() {
        return SongUrl;
    }

}
