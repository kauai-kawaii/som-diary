import Tooltip from './PopUp';

export default function Music({userName}){
    const message = `스포티파이 로고를 클릭하면, AI가 오늘 하루 ${userName}님의 일기와 맞게 노래를 추천해드립니다!`

    return (<div className="text-right flex sm:col-span-3 sm:col-start-8">
        {/* <Link to="https://accounts.spotify.com/ko/login/" target="_blank" rel="noopener noreferrer"> */}
        <div className="mt-2">
            <img src={process.env.PUBLIC_URL + '/img/spotify.png'} alt='x' style={{width:'40px' ,cursor: 'pointer'}}/>
        </div>
        {/* </Link> */}

        <div className="mt-2 sm:col-span-2"
             style={{ width: '100%', cursor: 'pointer', position: 'relative'}}>
            <Tooltip content = {message}>
                <div className="block rounded-md border-0 py-2 text-gray-900 shadow-sm ring-1 ring-inset ring-gray-300 placeholder:text-gray-400 focus:ring-2 focus:ring-inset focus:ring-indigo-600 sm:text-sm sm:leading-6">
                    <p className='text-center'>오늘의 노래</p>
                </div>
            </Tooltip>
        </div>
    </div>)
}