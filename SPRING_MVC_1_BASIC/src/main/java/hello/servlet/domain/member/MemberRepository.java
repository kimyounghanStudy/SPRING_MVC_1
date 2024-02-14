package hello.servlet.domain.member;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * 동시성 문제가 고려되 어 있지 않음 !! 실무에서는 ConcurrentHashMap, AtomicLong 등을 사용을 해야한다 ..
 */
public class MemberRepository {
    private static Map<Long, Member> store = new HashMap<>();
    private static long sequence = 0L;
    // static 으로 했기 때문에 !!! MemberRepository가 많이 생성되어도 ! 딱 한번만 생성되자나~~ static ~
    // 추가 어차피 싱글톤으로 만들것이기 때문에 ~~ 위에 static은 필요없지만 그래도~
    private static final MemberRepository instance = new MemberRepository();
    // 스프링컨테이너 이용한할꺼니까 일단 싱글톤으로 만들어 놓자는 생각이래 ~ 그리고 그럴려면 생성자를 막아야해~

    public static MemberRepository getInstance() {
        return instance;
    }
    private MemberRepository() {

    }

    public Member save(Member member) {
        member.setId(++sequence);
        store.put(member.getId(), member);
        return member;
    }

    public Member findById(Long id) {
        return store.get(id);
    }

    public List<Member> findAll() {
        return new ArrayList<>(store.values());  // 이렇게 해주면 store 원본을 보호해줄수있다..
    }

    public void clearStore() {
        store.clear();
    }
}
