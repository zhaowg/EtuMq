package tt.notice.service;

import static org.junit.Assert.*;

import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import tt.notice.vo.NoticeVo;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/server_ctx.xml" })
public class INoticeServiceTest
{
    
    @Resource
    private INoticeService noticeService;

    @Test
    public void testAddNoticeStringStringNoticeInfo()
    {
        fail("Not yet implemented");
    }

    @Test
    public void testGetNotices()
    {
        String gid = "gwB4RsWI";
        String ruid = "15117988858595";
        List<NoticeVo> list = noticeService.getNotices(gid, ruid, 0, 8);
        
        System.out.println("===============================\n"+list.toString());
    }

    @Test
    public void testCountNoRead()
    {
        String gid = "JOA4l9Rg";
        String ruid = "12328692642496";
        int count = noticeService.countNoRead(gid, ruid);
        
        System.out.println("===============================\n"+count);
    }

    @Test
    public void testAddNoticeStringStringNoticeInfoArray()
    {
        fail("Not yet implemented");
    }

}
