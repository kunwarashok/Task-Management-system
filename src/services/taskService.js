import axios from 'axios';

const API_BASE_URL = 'http://localhost:8080/api/tasks';

const taskService = {
    getAllTasks: () => {
        return axios.get(API_BASE_URL);
    },
    createTask: (taskData) => {
        return axios.post(API_BASE_URL, taskData);
    },
};

export default taskService;
