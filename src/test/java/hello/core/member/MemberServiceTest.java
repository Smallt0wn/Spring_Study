package hello.core.member;

import hello.core.AppConfig;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MemberServiceTest {


    MemberService memberService;

    @BeforeEach
    public void beforeEach(){
        AppConfig appConfig = new AppConfig();
        memberService = appConfig.memberService();
    }

    @Test
    void join() {
        //given (이런게 주어졌을때)
        Member member = new Member(1L, "MemberA", Grade.VIP);

        //when (이렇게 하면)
        memberService.join(member);
        Member findMember = memberService.findMember(1L);

        //then (이렇게 된다)

        Assertions.assertThat(member).isEqualTo(findMember);
    }

    //test 작성방법을 잘 알아야한다.
}
