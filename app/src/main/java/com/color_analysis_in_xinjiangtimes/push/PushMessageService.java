package com.color_analysis_in_xinjiangtimes.push;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import java.util.List;

import de.greenrobot.dao.query.QueryBuilder;
import de.greenrobot.dao.query.WhereCondition;

/**
 * Created by Kalen on 15/6/2.
 */
public class PushMessageService {

    private Context context;

    private SQLiteDatabase db;

    private DaoMaster daoMaster;

    private DaoSession daoSession;

    private PushMessageDao pushMessageDao;

    private MoreDao moreMessageDao;

    private static PushMessageService service;

    public static PushMessageService getService(Context context) {
        if (service == null) {
            service = new PushMessageService(context);
        }
        return service;
    }

    private PushMessageService(Context context) {
        this.context = context;
        DaoMaster.DevOpenHelper helper = new DaoMaster.DevOpenHelper(context, "push-dao", null);
        db = helper.getWritableDatabase();
        daoMaster = new DaoMaster(db);
        daoSession = daoMaster.newSession();
        pushMessageDao = daoSession.getPushMessageDao();
        moreMessageDao = daoSession.getMoreDao();

    }


    public void deleteMessage(PushMessage message) {
        pushMessageDao.delete(message);
    }


    public long getNotReadMessageCount() {
        QueryBuilder<PushMessage> builder = pushMessageDao.queryBuilder();
        WhereCondition read = PushMessageDao.Properties.IsRead.eq(Boolean.FALSE);
        builder.where(read);
        return builder.count();
    }

    public void readMessage(PushMessage message) {
        message.setIsRead(Boolean.TRUE);
        pushMessageDao.update(message);
    }

//    public void clearOrderChange() {
//        QueryBuilder<PushMessage> builder = pushMessageDao.queryBuilder();
//        WhereCondition where = PushMessageDao.Properties.MessageType.eq(Fields.ORDER_CHANGE);
//        builder.where(where);
//        List<PushMessage> messages = builder.list();
//        if (messages == null || messages.size() == 0) {
//            return;
//        }
//        for (PushMessage message : messages) {
//            readMessage(message);
//        }
//    }
//
//    public List<PushMessage> getPushMessageByRemind() {
//        QueryBuilder<PushMessage> builder = pushMessageDao.queryBuilder();
//
//        builder.where(builder.or(PushMessageDao.Properties.MessageType.eq(Fields.ORDER_CHANGE),
//                PushMessageDao.Properties.MessageType.eq(Fields.PAY_SUCCESS)));
//        builder.orderDesc(PushMessageDao.Properties.MessageTime);
//
//        return builder.list();
//    }

    public List<PushMessage> getAllMessage(String auntId) {
        QueryBuilder<PushMessage> builder = pushMessageDao.queryBuilder();
        WhereCondition where = PushMessageDao.Properties.UserId.eq(auntId);
        builder.where(where);
        builder.orderDesc(PushMessageDao.Properties.MessageTime);

        return builder.list();
    }

    private String getMessageType(int type) {
        String messageType = null;
        switch (type) {
            case 0:
//                messageType = Constants.ORDER_CHANGE;
                break;

        }
        return messageType;

    }

    public List<PushMessage> getAllMessage(String userId, String... types) {
        QueryBuilder<PushMessage> builder = pushMessageDao.queryBuilder();
        WhereCondition where = PushMessageDao.Properties.UserId.eq(userId);

//        builder.and(where, PushMessageDao.Properties.MessageType.eq(getMessageType(type)));
        if (types != null) {
            WhereCondition[] conditions = new WhereCondition[types.length];
            for (int i = 0; i < conditions.length; i++) {
                WhereCondition read = PushMessageDao.Properties.MessageType.eq(types[i]);
                conditions[i] = read;
            }
            builder.where(where, conditions);
        } else {
            builder.where(where);
        }


        builder.orderDesc(PushMessageDao.Properties.MessageTime);
        return builder.list();
    }

    public List<PushMessage> getAllMessage(boolean isRead, String userId, String... types) {
        QueryBuilder<PushMessage> builder = pushMessageDao.queryBuilder();
        WhereCondition where = PushMessageDao.Properties.UserId.eq(userId);

        if (types != null) {
            WhereCondition[] conditions = new WhereCondition[types.length+1];
            for (int i = 0; i < types.length; i++) {
                WhereCondition read = PushMessageDao.Properties.MessageType.eq(types[i]);
                conditions[i] = read;
            }
            conditions[types.length]= PushMessageDao.Properties.IsRead.eq(isRead? Boolean.TRUE: Boolean.FALSE);
            builder.where(where, conditions);
        } else {
            builder.where(where);
        }

        builder.orderDesc(PushMessageDao.Properties.MessageTime);
        return builder.list();
    }
    public long getAllMessageCount(boolean isRead, String userId, String... types) {
        QueryBuilder<PushMessage> builder = pushMessageDao.queryBuilder();
        WhereCondition where = PushMessageDao.Properties.UserId.eq(userId);

        if (types != null) {
            WhereCondition[] conditions = new WhereCondition[types.length+1];
            for (int i = 0; i < types.length; i++) {
                WhereCondition read = PushMessageDao.Properties.MessageType.eq(types[i]);
                conditions[i] = read;
            }
            conditions[types.length]= PushMessageDao.Properties.IsRead.eq(isRead? Boolean.TRUE: Boolean.FALSE);
            builder.where(where, conditions);
        } else {
            builder.where(where);
        }

        builder.orderDesc(PushMessageDao.Properties.MessageTime);
        return builder.count();
    }

    public long getAllMessageCountUnRead(String auntId) {
        QueryBuilder<PushMessage> builder = pushMessageDao.queryBuilder();
        WhereCondition where = PushMessageDao.Properties.UserId.eq(auntId);
        WhereCondition read = PushMessageDao.Properties.IsRead.eq(Boolean.FALSE);
        builder.where(where, read);
        return builder.count();
    }



    public void insertMore(More moreMessage) {
        long id = moreMessageDao.insert(moreMessage);
        moreMessage.setId(id);
    }

    public void insert(PushMessage message) {
        pushMessageDao.insert(message);
    }
}
