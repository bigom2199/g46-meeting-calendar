package lexicon.se.dao;

import lexicon.se.model.Meeting;

import java.util.Collection;
import java.util.Optional;

public interface MeetingDao {
    Meeting createMeeting(Meeting meeting);
    Optional<Meeting>findById(int meetingId);
    Collection<Meeting> findAllMeetingsByCalendarId(int calendarId);
    boolean deleteMeeting(int meetingId);
    // add methods for updating meeting  as needed...
}
