package bridge.model;

import java.util.ArrayList;
import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    private static final String RETRY = "R";
    private static final String QUIT = "Q";
    private List<String> marks; // "O",
    private int gameCount;
    List<String> bridge;
    BridgeMaker bridgeMaker;
    private int position;

    public BridgeGame() {
        this.marks = new ArrayList<>();
        this.bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        gameCount = 1;
        position = 0;
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void move(String userInputCourse) {
        if (!isAbleToCross(userInputCourse)) {
            marks.add("X");
            return;
        }
        marks.add("O");
        position++;
    }

    public boolean isAbleToCross(String course) {
        return bridge.get(position).equals(course);
    }

    /**
     * 사용자의 입력과 현재까지 건너온 길의 마지막이 불일치하는지 검증하는 메소드
     * @return
     */
    public boolean isDiscord() {
        return marks.get(marks.size() - 1).equals("X");
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public boolean retry(String cmd) {
        if(cmd.equals(RETRY)) {
            gameCount++;
            return true;
        }
        return false;
    }

    /**
     * 재시작일 경우 현재 다리를 건넌 상태를 초기화 하는 메소드
     */
    public void backToFirstSection() {
        position = 0;
        marks.clear();
    }

    public void makeBridge(int size) {
        bridge = bridgeMaker.makeBridge(size);
    }
}
