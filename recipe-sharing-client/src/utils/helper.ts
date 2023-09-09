export const firstLetterUpperCase = (str: string) => {
    return str
      .replace(/[a-z]/gi, (m: any, o) => {
        if (m < {}) {
          return `${m}`;
        }
        return o ? m : m.toUpperCase();
      })
      .replace(/([a-z])([A-Z])/g, '$1 $2')
      .replace(/([A-Z])([A-Z][a-z])/g, '$1 $2');
  };