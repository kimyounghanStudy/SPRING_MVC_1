package hello.servlet.domain.member;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

class MemberRepositoryTest {

    MemberRepository memberRepository = MemberRepository.getInstance();

    //test 끝날 때마다 초기화 해줄라고
    @AfterEach
    void afterEach() {
        memberRepository.clearStore();
    }

    @Test
    void save() {
        //given
        Member member = new Member("hello", 20);
        //when
        Member saveMember = memberRepository.save(member);

        //then
        Member findMember = memberRepository.findById(saveMember.getId());
        Assertions.assertThat(findMember).isEqualTo(saveMember);

    }

    @Test
    void findAll() {
        //g
        Member member1 = new Member("member1", 20);
        Member member2 = new Member("member2", 10);

        memberRepository.save(member1);
        memberRepository.save(member2);
        //w
        List<Member> memberList = memberRepository.findAll();

        //t
        Assertions.assertThat(memberList.size()).isEqualTo(2);
        Assertions.assertThat(memberList).contains(member1, member2);
    }

}
