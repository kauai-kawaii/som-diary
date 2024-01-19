import { useState } from "react";
export default function WeatherUpload({location}){
    location=null;

    const[weather,setWeather] = useState("날씨 없음 /(ㄒoㄒ)/~~");

    return (<div className="sm:col-span-2">
        <div className="mt-2">
            <div className="block w-full rounded-md border-0 py-2 text-gray-900 shadow-sm ring-1 ring-inset ring-gray-300 placeholder:text-gray-400 focus:ring-2 focus:ring-inset focus:ring-indigo-600 sm:text-sm sm:leading-6">
                {location ? ( <p className='text-center'>날씨정보</p>) : ( <p className='text-center'>{weather}</p>)}
            </div>
        </div>
    </div>)
}