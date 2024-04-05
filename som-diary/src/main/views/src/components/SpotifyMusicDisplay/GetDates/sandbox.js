import React, { useState, useEffect } from 'react';
import axios from 'axios';

function DiaryTrackSelector() {
  const [year, setYear] = useState(new Date().getFullYear());
  const [month, setMonth] = useState(new Date().getMonth() + 1); // JavaScript months are 0-indexed
  const [tracks, setTracks] = useState([]);

  useEffect(() => {
    const fetchTracks = async () => {
      try {
        const response = await axios.get(`/api/diaries/tracks?year=${year}&month=${month}`);
        setTracks(response.data);
      } catch (error) {
        console.error('Error fetching tracks', error);
      }
    };

    fetchTracks();
  }, [year, month]);
Tr
  return (
    <div>
      <label>
        Year:
        <input type="number" value={year} onChange={e => setYear(e.target.value)} />
      </label>
      <label>
        Month:
        <input type="number" value={month} onChange={e => setMonth(e.target.value)} />
      </label>
      <ul>
        {tracks.map(track => (
          <li key={track.id}>{track.name} (ID: {track.id})</li>
        ))}
      </ul>
    </div>
  );
}

export default DiaryTrackSelector;
