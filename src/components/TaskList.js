import React, { useEffect, useState } from 'react';
import TaskItem from './TaskItem';
import taskService from '../services/taskService';

const TaskList = () => {
    const [tasks, setTasks] = useState([]);

    useEffect(() => {
        // Fetch tasks from the server
        const fetchTasks = async () => {
            const response = await taskService.getAllTasks();
            setTasks(response.data);
        };

        fetchTasks();
    }, []);

    return (
        <div>
            <h2>Task List</h2>
            {tasks.map((task) => (
                <TaskItem key={task.id} task={task} />
            ))}
        </div>
    );
};

export default TaskList;
