import java.util.*;

class Solution {

    Set<Integer> set = new HashSet<>();
    String[] user;
    String[] banned;

    public int solution(String[] user_id, String[] banned_id) {

        user = user_id;
        banned = banned_id;

        dfs(0, 0);

        return set.size();
    }

    void dfs(int depth, int mask) {

        // 모든 불량 사용자를 매칭한 경우
        if (depth == banned.length) {
            set.add(mask);
            return;
        }

        // 현재 banned_id와 매칭되는 user 찾기
        for (int i = 0; i < user.length; i++) {

            // 이미 선택된 사용자라면
            if ((mask & (1 << i)) != 0)
                continue;

            // 패턴이 맞지 않으면
            if (!match(user[i], banned[depth]))
                continue;

            dfs(depth + 1, mask | (1 << i));
        }
    }

    boolean match(String userId, String bannedId) {

        if (userId.length() != bannedId.length())
            return false;

        for (int i = 0; i < userId.length(); i++) {

            if (bannedId.charAt(i) == '*')
                continue;

            if (userId.charAt(i) != bannedId.charAt(i))
                return false;
        }

        return true;
    }
}