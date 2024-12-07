import java.util.List;

public class MeetingRoomSchedular {

    private MeetingRoomManager meetingRoomManager;

    MeetingRoomSchedular(MeetingRoomManager meetingRoomManager) {
        this.meetingRoomManager = meetingRoomManager;
    }

    List<MeetingRoom> getAvailableMeetingRooms(Meeting meeting) {
        return meetingRoomManager.getAvailableMeetingRooms(meeting.getTimeInterval(), meeting.getCapacity());
    }

    void bookMeetingRoom(MeetingRoom meetingRoom, TimeInterval timeInterval) {
        meetingRoomManager.bookMeetingRoom(meetingRoom.getId(), timeInterval);
    }

}
