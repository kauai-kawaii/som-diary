import React from 'react';
import { useHistory } from 'react-router-dom';

function GoogleLoginButton() {
    // 구글 소셜 로그인 클라이언트 ID와 리다이렉션 URL
    const googleClientId = '474242660633-4c8dskcflpruc8ip83fp6udr724lg5qo.apps.googleusercontent.com';
    const redirectUrl = 'http://localhost:8081/login/oauth2/code/google';

    const handleGoogleLogin = () => {
        // 구글 소셜 로그인 링크
        const googleLoginUrl = `https://accounts.google.com/o/oauth2/v2/auth?client_id=${googleClientId}&redirect_uri=${redirectUrl}&response_type=code&scope=profile`;
        window.location.href = googleLoginUrl;
    };

    return (
        <button onClick={handleGoogleLogin}>
            <img
                src={'sign-in-with-google.png'}
                alt={'sign-in'}
                className={'max-w-40 sm:max-w-52 hover:opacity-75'}
            />
        </button>
    );
};

export default GoogleLoginButton;