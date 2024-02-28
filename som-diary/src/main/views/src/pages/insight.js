import YearPicker from "../components/GetDates/select-year";
import MonthPicker from "../components/GetDates/select-month";
import SpotifyHorizonSongList from "../components/SpotifyMusicDisplay/get-monthly-list";
import NaverMapsStars from "../components/MapApiDisplay/NaverMapsStars";
import DateSelector from "../components/SpotifyMusicDisplay/fetch-spotify-songs";

export default function Insight() {
  /* <Logo /> */
  return (
    <>
      <div className="grid grid-cols-5">
        <header className="col-span-1">
          <h1 className="text-2xl ml-4 mt-4">Dashboard</h1>
          <div className="flex">
            <DateSelector />
          </div>
        </header>
        <main className="col-span-4">
          <h2 className="text-xl ml-4 mt-4">Spotify: </h2>
          <SpotifyHorizonSongList />
          <h2 className="text-xl ml-4 mt-4">지도 API 출동 예정</h2>
          <NaverMapsStars />
        </main>
      </div>
    </>
  );
}
