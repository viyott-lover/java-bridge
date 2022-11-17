package bridge.domain;

import bridge.enums.InputKey;

import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    public static final int BLANK = 32;

    private final List<String> bridge;
    private Result result;

    private int position = -1;
    private int count = 0;

    public BridgeGame(List<String> bridge) {
        this.bridge = bridge;
        result = new Result(bridge.size());
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public int move(String key) {
        String upOrDown = bridge.get(++position);
        count++;
        if (key.equals(InputKey.U.getValue())) {
            return result.handleUpBridge(upOrDown, position);
        }
        return result.handleDownBridge(upOrDown, position);
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
        result.clear();
        position = -1;
        count = 0;
    }

    public boolean isDone() {
        return position == bridge.size() - 1;
    }

    public int getBridgeSize() {
        return bridge.size();
    }

    public String printResult() {
        return result.printGameResult();
    }

    @Override
    public String toString() {
        return result.printStatus(count);
    }
}
