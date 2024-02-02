import React, { useState, useEffect } from "react";

const {kakao} = window;
export default function Location() {
    const [searchResults, setSearchResults] = useState([]);

    useEffect(() => {
        var infowindow = new kakao.maps.InfoWindow({zIndex:1});

        var mapContainer = document.getElementById('map'),
            mapOption = {
                center: new kakao.maps.LatLng(37.566826, 126.9786567),
                level: 3
            };

        // 지도를 생성합니다
        var map = new kakao.maps.Map(mapContainer, mapOption);

        var searchButton = document.getElementById("search-btn");
        searchButton.addEventListener('click', ()=>{
            var searchInput = document.getElementById("search-input").value;
            var ps = new kakao.maps.services.Places();
            ps.keywordSearch(searchInput, placesSearchCB);
            updateList()
        })

        function placesSearchCB (data, status, pagination) {
            if (status === kakao.maps.services.Status.OK) {
                var bounds = new kakao.maps.LatLngBounds();
                setSearchResults(data);
                for (var i=0; i<data.length; i++) {
                    displayMarker(data[i]);
                    displayList(data[i]);
                    bounds.extend(new kakao.maps.LatLng(data[i].y, data[i].x));
                }

                map.setBounds(bounds);
            }
        }

        function displayMarker(place) {
            var marker = new kakao.maps.Marker({
                map: map,
                position: new kakao.maps.LatLng(place.y, place.x)
            });

            kakao.maps.event.addListener(marker, 'click', function() {
                infowindow.setContent('<div style="padding:5px;font-size:12px;">' + place.place_name + '</div>');
                infowindow.open(map, marker);
            });
        }

        function displayList(place) {
            var mapListContainer = document.getElementById("location-list");

            var listItem = document.createElement("div");
            listItem.className = "mb-2";
            listItem.innerHTML =
                '<div class="font-nomal text-gray-900 text-xs border-gray-600">' + place.place_name + "</div>";


            mapListContainer.appendChild(listItem);
        }

        function updateList() {
            var mapListContainer = document.getElementById("location-list");
            mapListContainer.innerHTML = "";  // 기존 리스트 비우기

            for (var i = 0; i < searchResults.length; i++) {
                displayList(searchResults[i]);
            }
        }

    }, []);

    return (
        <div className="p-5">
            <div className="mb-2 sm:flex-row">
                <input
                    id="search-input"
                    type="text"
                    placeholder="위치 검색"
                    className="p-1 mb-2 sm:mb-0 sm:mr-2 w-full sm:w-auto border border-gray-400"
                />
                <input
                    id="search-btn"
                    type="button"
                    value="검색"
                    className="inline-flex items-center rounded-md bg-blue-50 px-3 py-2 text-xs font-medium text-blue-700 ring-1 ring-inset ring-blue-700/10"
                    style={{ cursor: "pointer" }}
                />
            </div>

            <div className="flex flex-col sm:flex-row">
                {/*검색 결과 리스트*/}
                <div id="location-list"
                     className="border border-gray-400 p-2 mb-2 sm:mb-0 sm:mr-2 w-full sm:w-auto"
                     style={{width: "195px"}}>
                </div>

                {/*지도 마커 표시*/}
                <div
                    id="map"
                    className="border border-gray-400 p-2 w-full sm:w-auto"
                    style={{height: '400px', width: '500px'}}
                ></div>
            </div>

            <input
                type="button"
                value="확인"
                className="mt-2 sm:mt-2 inline-flex items-center rounded-md bg-gray-50 px-3 py-2 text-xs font-medium text-gray-600 ring-1 ring-inset ring-gray-500/10"
                style={{cursor: "pointer"}}
            />
        </div>
    );
}


