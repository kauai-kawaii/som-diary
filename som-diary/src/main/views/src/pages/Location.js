import React, { useEffect } from "react";

export default function Location() {
    useEffect(() => {
        const script = document.createElement("script");
        script.src = "https://openapi.map.naver.com/openapi/v3/maps.js?ncpClientId=eui51z57hp";
        script.async = true;
        script.defer = true;
        document.head.appendChild(script);

        script.onload = () => {
            // 네이버 지도 생성
            new window.naver.maps.Map("map", {
                center: new window.naver.maps.LatLng(37.5670135, 126.9783740),
                zoom: 10
            });
        };
    }, []);

    return (
        <div className="p-5">
            <div className="mb-2 sm:flex-row">
                <input
                    type="text"
                    placeholder="위치 검색"
                    className="p-1 mb-2 sm:mb-0 sm:mr-2 w-full sm:w-auto border border-gray-400"
                />
                <input
                    type="button"
                    value="검색"
                    className="inline-flex items-center rounded-md bg-blue-50 px-3 py-2 text-xs font-medium text-blue-700 ring-1 ring-inset ring-blue-700/10"
                    style={{ cursor: "pointer" }}
                />
            </div>

            <div className="flex flex-col sm:flex-row">
                <div className="border border-gray-400 p-2 mb-2 sm:mb-0 sm:mr-2 w-full sm:w-auto" style={{width:"195px"}}>
                    주소검색리스트
                </div>
                <div
                    id="map"
                    className="border border-gray-400 p-2 w-full sm:w-auto"
                    style={{ height: '400px', width:'500px'}}
                ></div>
            </div>

            <input
                type="button"
                value="확인"
                className="mt-2 sm:mt-2 inline-flex items-center rounded-md bg-gray-50 px-3 py-2 text-xs font-medium text-gray-600 ring-1 ring-inset ring-gray-500/10"
                style={{ cursor: "pointer" }}
            />
        </div>
    );
}
