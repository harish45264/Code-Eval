import axios from 'axios';

const API_BASE_URL = 'http://localhost:8080';
const api = axios.create({
  baseURL: API_BASE_URL,
  headers: {
    'Content-Type': 'application/json'
  }
});
// Add request interceptor for auth tokens if needed
api.interceptors.request.use(
  config => {
    const token = localStorage.getItem('token');
    if (token) {
      config.headers['Authorization'] = `Bearer ${token}`;
    }
    return config;
  },
  error => Promise.reject(error)
);
export const productService = {
  getAll: () => api.get('/problems'),
  getById: (id:number) => api.get(`/problems/${id}`),
  create: (data:any) => api.post('/problems', data),
  update: (id:number, data:any) => api.put(`/problems/${id}`, data),
  delete: (id:number) => api.delete(`/problems/${id}`)
};
export default api;