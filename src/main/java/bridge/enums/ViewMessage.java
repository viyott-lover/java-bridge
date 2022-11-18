package bridge.enums;

public enum ViewMessage {
    INPUT_START_GAME("다리 건너기 게임을 시작합니다."),
    INPUT_BRIDGE_LENGTH("다리의 길이를 입력해주세요."),
    INPUT_UP_DOWN("이동할 칸을 선택해주세요. (위: U, 아래: D)"),
    INPUT_RETRY_OR_QUIT("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)");



    private final String value;

    ViewMessage(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
