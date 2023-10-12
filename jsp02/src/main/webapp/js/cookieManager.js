function createCookie(key, value) {
  const expiration = new Date();
  expiration.setDate(expiration.getDate() + 30);

  const cookies = `${encodeURIComponent(key)}=${encodeURIComponent(
      value)}; expires=${expiration.toUTCString()}; path=/`;

  document.cookie = cookies;
}

function getCookie(name) {
  const cookies = document.cookie.split(';');
  for (const cookie of cookies) {
    const trimCookie = cookie.trim();
    //trim 해주지 않으면 cookieName을 조회하지 못함..
    const [cookieName, cookieValue] = trimCookie.split('=');
    if (cookieName === name) {

      return decodeURIComponent(cookieValue);
    }
  }
  return null;
}

function removeCookie(name) {
  document.cookie = `${name}=; expires= Thu, 01 Jan 1970 00:00:00 UTC; path=/;`;
}