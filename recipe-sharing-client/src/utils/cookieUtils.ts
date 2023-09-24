  export const setCookieValue = (
    key: string,
    value: string,
    expireDate?: Date,
    path?: string,
    domain?: string
  ): void => {
    let cookieValue = `${encodeURIComponent(key)}=`;
    if (value) {
      cookieValue += encodeURIComponent(value);
    }
  
    if (expireDate) {
      cookieValue = `${cookieValue}; expires=${expireDate.toUTCString()}`;
    }
  
    if (path) {
      cookieValue = `${cookieValue}; path=${path}`;
    }
  
    if (domain) {
      cookieValue = `${cookieValue}; domain=${domain}`;
    }
    document.cookie = cookieValue;
  };
  
  /**
   * Gets a cookie with the given key.
   * You should use a complete cookie library if need something more complete.
   * This is only to be used for ABP.
   * @param key the key of the cookie we need the value for
   * @returns The Cookie value if found, otherwise null.
   */
  export const getCookieValue = (key: string): string | null => {
    debugger
    const equalities = document.cookie.split('; ');
    for (let i = 0; i < equalities.length; i++) {
      if (equalities[i]) {
        const splitted = equalities[i].split('=');
        
        if (splitted.length === 2) {
          if (decodeURIComponent(splitted[0]) === key) {
            return decodeURIComponent(splitted[1] || '');
          }
        }
      }
    }
    return null;
  };
  
  /**
   * Deletes cookie with the given key.
   * You should use a complete cookie library if need something more complete.
   * This is only to be used for ABP.
   * @param key The key fo the cookie to delete
   * @param path path of the cookie, if needed.
   */
  export const deleteCookie = (key: string, path?: string): void => {
    let cookieValue = `${encodeURIComponent(key)}=`;
  
    cookieValue = `${cookieValue}; expires=${new Date(
      new Date().getTime() - 86400000
    ).toUTCString()}`;
  
    if (path) {
      cookieValue = `${cookieValue}; path=${path}`;
    }
  
    document.cookie = cookieValue;
  };
  