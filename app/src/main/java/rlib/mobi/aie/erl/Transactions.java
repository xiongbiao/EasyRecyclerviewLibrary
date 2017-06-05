package rlib.mobi.aie.erl;


import java.util.List;

/**
 * Created by xiongbiao on 17/2/6.
 */
public class Transactions  {

    public DataBean data;

    public List<TransactionsBean> transactions ;
    public static class DataBean {
        public List<TransactionsBean> transactions ;

    }

    public static class TransactionsBean {
        public String type;

        public String title;

        public String amount;

        public String balance;

        public String time;

        public String status;

        public boolean hasLuckyNum;

        public String typeId;
    }
}
