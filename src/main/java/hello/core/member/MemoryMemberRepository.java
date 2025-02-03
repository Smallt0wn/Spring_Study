package hello.core.member;

import java.util.HashMap;
import java.util.Map;

public class MemoryMemberRepository implements MemberRepository {

    private static Map<Long, Member> store = new HashMap<>();

    // 동시성 이슈가 있을 수 있기 때문에 HashMap 대신 'ConcurrentHashMap'을 사용하는 것이 좋다.
    @Override
    public void save(Member member) {
        store.put(member.getId(), member);
    }
    //예제이기에 간단하게 오류 검증 대신 진행한다.

    @Override
    public Member findById(Long memberId) {
        return store.get(memberId);
    }
}
