package com.chuangrong.tourism.ui.bean;

import java.util.List;

/**
 * Created by DELL on 2017/5/10.
 */

public class ScenicBean2 {

    @Override
    public String toString() {
        return "ScenicBean2{" +
                "code=" + code +
                ", message='" + message + '\'' +
                ", data=" + data +
                '}';
    }

    /**
     * code : 200
     * message : 成功
     * data : [{"scenicSpot_ID":1,"scenicSpot_Name":"ä¸œäº¬å¡\u201d","scenicSpot_Intro":"æ™¯åŒºç®\u20acä»\u2039","countryID":"æ\u2014¥æœ¬","cityID":"ä¸œäº¬","coverPhoto":"http://pic128.nipic.com/file/20170424/10703279_072403916000_2.jpg","scenicSpot_photos":"[{\"url\":\"http://pic128.nipic.com/file/20170424/10703279_072403916000_2.jpg\"},{\"url\":\"http://pic104.nipic.com/file/20160703/11851823_141402315000_2.jpg\"}]","longitude":0,"latitude":0,"category_ID":"1,2,3","scenicSpot_Price":15,"fsCount":1},{"scenicSpot_ID":2,"scenicSpot_Name":"æµ\u2026è�\u2030å¯º","scenicSpot_Intro":"æ™¯åŒºç®\u20acä»\u2039","countryID":"æ\u2014¥æœ¬","cityID":"ä¸œäº¬","coverPhoto":"http://pic95.huitu.com/res/20170408/219955_20170408192008349050_1.jpg","scenicSpot_photos":"[{\"url\":\"http://pic95.huitu.com/res/20170408/219955_20170408192008349050_1.jpg\"},{\"url\":\"http://pic86.huitu.com/res/20160919/50054_20160919161853087600_1.jpg\"}]","longitude":0,"latitude":0,"category_ID":"1,2,3","scenicSpot_Price":20,"fsCount":3},{"scenicSpot_ID":3,"scenicSpot_Name":"å¤§é˜ªåŸŽå\u2026¬å\u203a­","scenicSpot_Intro":"æ™¯åŒºç®\u20acä»\u2039","countryID":"æ\u2014¥æœ¬","cityID":"å¤§é˜ª","coverPhoto":"http://pic95.huitu.com/res/20170416/219955_20170416213450829050_1.jpg","scenicSpot_photos":"[{\"url\":\"http://pic95.huitu.com/res/20170416/219955_20170416213450829050_1.jpg\"},{\"url\":\"http://pic128.nipic.com/file/20170505/25193194_135840213000_2.jpg\"}]","longitude":0,"latitude":0,"category_ID":"1,2,3","scenicSpot_Price":20,"fsCount":1}]
     */

    private int code;
    private String message;
    private List<DataBean> data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        @Override
        public String toString() {
            return "DataBean{" +
                    "scenicSpot_ID=" + scenicSpot_ID +
                    ", scenicSpot_Name='" + scenicSpot_Name + '\'' +
                    ", scenicSpot_Intro='" + scenicSpot_Intro + '\'' +
                    ", countryID='" + countryID + '\'' +
                    ", cityID='" + cityID + '\'' +
                    ", coverPhoto='" + coverPhoto + '\'' +
                    ", scenicSpot_photos='" + scenicSpot_photos + '\'' +
                    ", longitude=" + longitude +
                    ", latitude=" + latitude +
                    ", category_ID='" + category_ID + '\'' +
                    ", scenicSpot_Price=" + scenicSpot_Price +
                    ", fsCount=" + fsCount +
                    '}';
        }

        /**
         * scenicSpot_ID : 1
         * scenicSpot_Name : ä¸œäº¬å¡”
         * scenicSpot_Intro : æ™¯åŒºç®€ä»‹
         * countryID : æ—¥æœ¬
         * cityID : ä¸œäº¬
         * coverPhoto : http://pic128.nipic.com/file/20170424/10703279_072403916000_2.jpg
         * scenicSpot_photos : [{"url":"http://pic128.nipic.com/file/20170424/10703279_072403916000_2.jpg"},{"url":"http://pic104.nipic.com/file/20160703/11851823_141402315000_2.jpg"}]
         * longitude : 0
         * latitude : 0
         * category_ID : 1,2,3
         * scenicSpot_Price : 15
         * fsCount : 1
         */

        private int scenicSpot_ID;
        private String scenicSpot_Name;
        private String scenicSpot_Intro;
        private String countryID;
        private String cityID;
        private String coverPhoto;
        private String scenicSpot_photos;
        private int longitude;
        private int latitude;
        private String category_ID;
        private int scenicSpot_Price;
        private int fsCount;

        public int getScenicSpot_ID() {
            return scenicSpot_ID;
        }

        public void setScenicSpot_ID(int scenicSpot_ID) {
            this.scenicSpot_ID = scenicSpot_ID;
        }

        public String getScenicSpot_Name() {
            return scenicSpot_Name;
        }

        public void setScenicSpot_Name(String scenicSpot_Name) {
            this.scenicSpot_Name = scenicSpot_Name;
        }

        public String getScenicSpot_Intro() {
            return scenicSpot_Intro;
        }

        public void setScenicSpot_Intro(String scenicSpot_Intro) {
            this.scenicSpot_Intro = scenicSpot_Intro;
        }

        public String getCountryID() {
            return countryID;
        }

        public void setCountryID(String countryID) {
            this.countryID = countryID;
        }

        public String getCityID() {
            return cityID;
        }

        public void setCityID(String cityID) {
            this.cityID = cityID;
        }

        public String getCoverPhoto() {
            return coverPhoto;
        }

        public void setCoverPhoto(String coverPhoto) {
            this.coverPhoto = coverPhoto;
        }

        public String getScenicSpot_photos() {
            return scenicSpot_photos;
        }

        public void setScenicSpot_photos(String scenicSpot_photos) {
            this.scenicSpot_photos = scenicSpot_photos;
        }

        public int getLongitude() {
            return longitude;
        }

        public void setLongitude(int longitude) {
            this.longitude = longitude;
        }

        public int getLatitude() {
            return latitude;
        }

        public void setLatitude(int latitude) {
            this.latitude = latitude;
        }

        public String getCategory_ID() {
            return category_ID;
        }

        public void setCategory_ID(String category_ID) {
            this.category_ID = category_ID;
        }

        public int getScenicSpot_Price() {
            return scenicSpot_Price;
        }

        public void setScenicSpot_Price(int scenicSpot_Price) {
            this.scenicSpot_Price = scenicSpot_Price;
        }

        public int getFsCount() {
            return fsCount;
        }

        public void setFsCount(int fsCount) {
            this.fsCount = fsCount;
        }
    }
}
