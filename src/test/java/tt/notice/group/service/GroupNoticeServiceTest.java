package tt.notice.group.service;

import java.util.Date;
import java.util.Map;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import tt.notice.common.OperationType;
import tt.notice.handler.TTFeed;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/server_ctx.xml" })
public class GroupNoticeServiceTest
{
    
    @Resource
    private GroupNoticeService groupNoticeService;

    @Test
    public void testDoGroupNotice()
    {
        TTFeed feed = null;
        feed = getFeed(OperationType.inviteGroupMemberByUids);
        groupNoticeService.doGroupNotice(feed);
        
        
    }
    
    
    //String who, Date when, String objdata, String objType,
    //String where, String what, int opttype, String action,
    //String channel, String terminal, Map<String, String> param
    private TTFeed getFeed(int opttype){
        TTFeed feed = null;
        switch(opttype){
            case OperationType.inviteGroupMemberByUids:
                feed = new TTFeed("12328692642496",new Date(),"[\"12328692642496\",\"10052260578562\",\"14440764591540\",\"10376738480346\"]","UID",
                        "ZJa1OQqi_S","inviteGroupMemberByUids",4047,null,
                        "100000100","1",null);
            break;
            default:
            break;
        }
        
        return feed;
    }

}
