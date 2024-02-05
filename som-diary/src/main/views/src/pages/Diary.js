import ImageUpload from '../components/diary/ImageUpload';
import LocationUpload from '../components/diary/LocationUpload';
import Logo from '../components/Logo';
import SaveButton from '../components/diary/SaveButton';
import WeatherUpload from '../components/diary/WeatherUpload';
import ToolOptions from '../components/diary/Options'
import { useEffect, useState } from 'react';
import Music from '../components/diary/Music';
import { Link } from 'react-router-dom';
import axios from 'axios';
import { useLocation } from 'react-router-dom';

export default function Diary() {
    const locationData = useLocation();
    console.log(locationData.state);
    useEffect(() => {
        // const client_id = process.env.REACT_APP_CLIENT_ID;
        // const client_secret = process.env.REACT_APP_CLIENT_SECRET;
        // console.log(client_id)
        //
        // const authOptions = {
        //     url: 'https://accounts.spotify.com/api/token',
        //     headers: {
        //         'Authorization': 'Basic ' + btoa(`${client_id}:${client_secret}`)
        //     },
        //     data: 'grant_type=client_credentials'
        // };
        //
        // axios.post(authOptions.url, authOptions.data, { headers: authOptions.headers })
        //     .then(response => {
        //         const token = response.data.access_token;
        //         console.log(token);
        //         fetchArtist(token);
        //     })
        //     .catch(error => {
        //         console.error('Spotify access token fetching error:', error);
        //     });
        //
        // async function fetchArtist(token) {
        //     try {
        //         const result = await fetch(`https://api.spotify.com/v1/artists/0CmvFWTX9zmMNCUi6fHtAx`, {
        //             // method: "GET",
        //             headers: { Authorization: `Bearer ${token}` }
        //         });
        //
        //         if (!result.ok) {
        //             throw new Error(`Failed to fetch user profile. Status: ${result.status}`);
        //         }
        //
        //         const artistInfo = await result.json();
        //         console.log(artistInfo);
        //     } catch (error) {
        //         console.error('Error fetching user profile:', error);
        //     }
        // }


    }, []);

    const images = Array(4).fill(process.env.PUBLIC_URL + '/img/rabbit.jpg');
    const [selectedEmoji, setSelectedEmoji] = useState('😶');
    const emojis = ['😶','😊', '😥', '🤗', '🤬','🥰'];
    const handleEmojiClick = (emoji) => {
        setSelectedEmoji(emoji);
    };

    return (
        <form>
            <div className="space-y-12 ">
                <div className="m-20 mb-5 border-b border-gray-900/10 pb-12">
                    <Logo/>
                    {/* 상단 정보: 날짜 날씨 기분 노래*/}
                    <div className="mt-10 grid grid-cols-1 gap-x-4 gap-y-8 sm:grid-cols-10">
                        {/* 날짜 */}
                        <div className="sm:col-span-2 sm:col-start-1">
                            <div className="mt-2">
                                <div className="block w-full rounded-md border-0 py-2 text-gray-900 shadow-sm ring-1 ring-inset ring-gray-300 placeholder:text-gray-400 sm:text-sm sm:leading-6">
                                    <p className='text-center'>2024년 1월 11일</p>
                                </div>
                            </div>
                        </div>
                        {/* 날씨 */}
                        <WeatherUpload />
                        {/* 기분 */}
                        <div className="block sm:col-span-1 mt-2" style={{ width: '40px'}}>
                            <ToolOptions content={ <div className="flex gap-2 ">
                                {emojis.map((emoji, index) => (
                                    <div
                                        key={index}
                                        style={{ cursor: 'pointer', top: '0', left: '0' }}
                                        onClick={() => handleEmojiClick(emoji)}
                                    >
                                        <div
                                            className="p-1 hover:bg-yellow-100 block w-full rounded-full border-0 py-1 text-gray-900 shadow-sm ring-1 ring-inset ring-gray-300 placeholder:text-gray-400 sm:text-sm sm:leading-6"
                                            style={{ cursor: 'pointer'}}
                                        >
                                            <p className='text-center'>{emoji}</p>
                                        </div>
                                    </div>
                                ))}
                            </div>}
                            >
                                <div
                                    className="block rounded-md border-0 py-2 text-gray-900 shadow-sm ring-1 ring-inset ring-gray-300 placeholder:text-gray-400 sm:text-sm sm:leading-6"
                                    style={{ cursor: 'pointer'}}
                                >
                                    <p className='text-center'>{selectedEmoji}</p>
                                </div>
                            </ToolOptions>
                        </div>
                        {/* 노래 */}
                        <Music/>
                    </div>

                    {/* 하단: 이미지, 일기 */}
                    <div className="pt-0 grid grid-cols-1 gap-x-6 gap-y-8 sm:grid-cols-10">
                        {/* 하단 왼쪽: 사진 업로드, 위치 불러오기 */}
                        <div className="sm:col-span-2">
                            {/* 중간에 토끼 */}
                            <div className="pt-5 gap-5 flex flex-wrap" style={{ display: 'flex', alignItems: 'center', justifyContent: 'center' }}>
                                {images.map((image, index) => (
                                    <img
                                        key={index}
                                        src={image}
                                        alt='x'
                                        style={{ width: '40px' }}
                                    />
                                ))}
                            </div>
                            <ImageUpload/>
                            <LocationUpload data={locationData.state} />
                        </div>
                        {/* 하단 오른쪽 */}
                        <div className="sm:col-span-8">
                            <div className="mt-6">
                                <input
                                    placeholder='제목'
                                    type="text"
                                    name="title"
                                    id="first-name"
                                    autoComplete="given-name"
                                    className="block w-full rounded-md border-0 py-1.5 text-gray-900 shadow-sm ring-1 ring-inset ring-gray-300 placeholder:text-gray-400 focus:ring-2 focus:ring-inset focus:ring-blue-200 sm:text-sm sm:leading-6 mt-2"
                                />
                            </div>

                            <div className="mt-3">
                  <textarea
                      id="about"
                      name="about"
                      rows={20}
                      className="block w-full rounded-md border-0 py-1.5 text-gray-900 shadow-sm ring-1 ring-inset ring-gray-300 placeholder:text-gray-400 focus:ring-2 focus:ring-inset focus:ring-blue-200 sm:text-sm sm:leading-6 mt-2"
                      defaultValue={''}
                  />
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            {/* 취소, 저장 버튼 */}
            <div className=" mr-20 flex items-center justify-end gap-x-6">
                <Link to="/UserCalendar">
                    <button type="button" className="inline-flex items-center rounded-md bg-gray-50 px-3 py-2 text-xs font-medium text-gray-600 ring-1 ring-inset ring-gray-500/10">
                        취소
                    </button>
                </Link>
                <SaveButton/>
            </div>
        </form>
    )
}